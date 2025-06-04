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
