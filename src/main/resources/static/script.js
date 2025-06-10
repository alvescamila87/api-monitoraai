//EXCLUSÃO DO USUARIO - LISTA
document.querySelectorAll(".delete-user").forEach(function (button) {
  button.addEventListener("click", function () {
    if (confirm("Confirma a exclusão?")) {
      const row = this.closest("tr"); // Obtém a linha atual da tabela

      const usuarioId = this.dataset.userId;

      // Realize a chamada AJAX para excluir o recurso
      fetch(`/crud/usuario/${usuarioId}`, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((response) => {
          if (response.ok) {
            // A exclusão foi bem-sucedida
            console.log("Usuário excluído com sucesso.");

            // Remove a linha da tabela após a exclusão
            row.remove();
          } else {
            // A solicitação DELETE falhou
            console.error("Erro ao excluir usuário.");
            alert("Erro ao excluir usuário");
          }
        })
        .catch((error) => {
          // Lidar com erros de rede ou outros erros
          console.error("Erro de rede:", error);
          alert("Erro de rede:" + error);
        });
    }
  });
});

//EXCLUSÃO DO EQUIPAMENTO - LISTA
document.querySelectorAll(".delete-equipment").forEach(function (button) {
  button.addEventListener("click", function () {
    if (confirm("Confirma a exclusão?")) {
      const row = this.closest("tr"); // Obtém a linha atual da tabela

      const equipamentoId = this.dataset.equipmentId;

      // Realize a chamada AJAX para excluir o recurso
      fetch(`/crud/equipamento/${equipamentoId}`, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((response) => {
          if (response.ok) {
            // A exclusão foi bem-sucedida
            console.log("Equipamento excluído com sucesso.");

            // Remove a linha da tabela após a exclusão
            row.remove();
          } else {
            // A solicitação DELETE falhou
            console.error("Erro ao excluir Equipamento.");
            alert("Erro ao excluir Equipamento");
          }
        })
        .catch((error) => {
          // Lidar com erros de rede ou outros erros
          console.error("Erro de rede:", error);
          alert("Erro de rede:" + error);
        });
    }
  });
});

//EXCLUSÃO DO COLABORADOR - LISTA
document.querySelectorAll(".delete-colaborador").forEach(function (button) {
  button.addEventListener("click", function () {
    if (confirm("Confirma a exclusão?")) {
      const row = this.closest("tr"); // Obtém a linha atual da tabela

      const colaboradorId = this.dataset.colaboradorId;

      // Realize a chamada AJAX para excluir o recurso
      fetch(`/crud/colaborador/${colaboradorId}`, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((response) => {
          if (response.ok) {
            // A exclusão foi bem-sucedida
            console.log("Colaborador excluído com sucesso.");

            // Remove a linha da tabela após a exclusão
            row.remove();
          } else {
            // A solicitação DELETE falhou
            console.error("Erro ao excluir Colaborador.");
            alert("Erro ao excluir Colaborador");
          }
        })
        .catch((error) => {
          // Lidar com erros de rede ou outros erros
          console.error("Erro de rede:", error);
          alert("Erro de rede:" + error);
        });
    }
  });
});

//LEITURA DE QRCODE
function startScanner() {
  const scannerDiv = document.getElementById("qr-reader");
  scannerDiv.style.display = "block";

  const html5QrCode = new Html5Qrcode("qr-reader");
  html5QrCode
    .start(
      { facingMode: "environment" }, // câmera traseira em celular
      {
        fps: 10,
        qrbox: { width: 250, height: 250 },
      },
      (qrCodeMessage) => {
        console.log("QR Code lido:", qrCodeMessage);
        // Ex: qrCodeMessage = "123", então redireciona para devolução
        //window.location.href = `/devolver-equipamento/${qrCodeMessage}`;
        window.location.href = `/devolucao/qrcode/${qrCodeMessage}`;
        html5QrCode.stop();
      },
      (errorMessage) => {
        // Pode ignorar erros de leitura frequentes
      }
    )
    .catch((err) => {
      console.error("Erro ao iniciar scanner:", err);
    });
}
