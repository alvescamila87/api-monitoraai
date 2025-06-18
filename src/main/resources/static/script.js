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
    let html5QrCode = null;

    function startScanner() {
        const container = document.getElementById("qr-reader-container");
        container.style.display = "block";

        if (!html5QrCode) {
            html5QrCode = new Html5Qrcode("qr-reader");
        }

        html5QrCode.start(
            { facingMode: "environment" },
            { fps: 10, qrbox: { width: 250, height: 250 } },
            (decodedText, decodedResult) => {
                if (decodedText.includes("/devolucao/qrcode/")) {
                    const id = decodedText.split("/devolucao/qrcode/")[1];

                    fetch(`/devolucao/qrcode/${id}`, {
                        method: 'POST'
                    })
                    .then(response => {
                        if (response.ok) {
                            alert("Equipamento devolvido com sucesso!");
                            stopScanner();
                            window.location.href = "/lista-emprestimo";
                        } else {
                            alert("Erro ao devolver equipamento.");
                        }
                    })
                    .catch(err => {
                        alert("Erro na solicitação de devolução.");
                        console.error(err);
                    });
                } else {
                    alert("QR Code inválido.");
                }
            },
            (errorMessage) => {
                // silencioso para erros de leitura
            }
        ).catch((err) => {
            console.error("Erro ao iniciar scanner:", err);
        });
    }

    function stopScanner() {
        const container = document.getElementById("qr-reader-container");
        if (html5QrCode) {
            html5QrCode.stop().then(() => {
                html5QrCode.clear();
                container.style.display = "none";
            }).catch((err) => {
                console.error("Erro ao parar scanner:", err);
                container.style.display = "none";
            });
        } else {
            container.style.display = "none";
        }
    }

//VALIDAÇÃO DE DATA NASCIMENTO - COLABORADOR
$(document).ready(function () {
    $('#colaborador_data_nascimento').inputmask('99/99/9999');
  });