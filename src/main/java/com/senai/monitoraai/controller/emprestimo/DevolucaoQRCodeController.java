package com.senai.monitoraai.controller.emprestimo;

import com.senai.monitoraai.dtos.colaborador.ColaboradorListaDTO;
import com.senai.monitoraai.dtos.emprestimo.DevolucaoDTO;
import com.senai.monitoraai.dtos.emprestimo.DevolucaoPorQRCodeRequestDTO;
import com.senai.monitoraai.dtos.equipamento.EquipamentoListaDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.ColaboradorService;
import com.senai.monitoraai.services.EmprestimoService;
import com.senai.monitoraai.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.ByteArrayOutputStream;

@Controller
@RequestMapping("/devolucao/qrcode")
public class DevolucaoQRCodeController {

    @Autowired
    EmprestimoService emprestimoService;

    /**
     * Devolução automática por QRCode, considerando equipamentos de EPI em condições no normais de devolução.
     * @param id:  id de empréstimo
     * @return: devolução realizada com sucesso
     */
    @PostMapping("/{id}")
    public String devolverPorQRCode(@PathVariable Long id,
                                     RedirectAttributes redirectAttributes) throws Exception, RuntimeException{
        try {
            emprestimoService.devolverEquipamentoPorQRCode(id);
            redirectAttributes.addFlashAttribute("mensagem", "Equipamento devolvido com sucesso.");
            return "redirect:/lista-emprestimo";

        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-emprestimo";
        } catch (RuntimeException exception) {

            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-emprestimo";

        }
    }

    /**
     * Gera imagem para leitura de QRCode por empréstimo de equipamento
     * @param id:  id de empréstimo
     * @return: uma imagem em QRCode
     */
    @GetMapping(value = "/imagem/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> gerarQRCode(@PathVariable Long id) {
        try {
            String texto = "http://localhost:8080//devolucao/qrcode/" + id;
            //String texto = "http://192.168.100.10:8080/devolucao/qrcode/" + id; //ipConfig IPv4 Address
            BitMatrix matrix = new MultiFormatWriter().encode(texto, BarcodeFormat.QR_CODE, 300, 300);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream);

            return ResponseEntity.ok().body(outputStream.toByteArray());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
