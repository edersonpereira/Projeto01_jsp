
<%
	try {
		//Obter a mensagem
		String mensagem = request.getParameter("mensagem");
		//Escolha
		switch (mensagem) {
		case "falhaCriarConta":
			out.print("<div class='alert alert-danger'>Falha ao criar a conta, tente novamente.</div>");
			break;
		case "falhaLogin":
			out.print("<div class='alert alert-danger'>Falha ao acessar a conta.</div>");
			break;
		case "sessaoExpirada":
			out.print("<div class='alert alert-danger'>Sessão expirada, faça o loguin novamente.</div>");
			break;
		case "usuarioIncorreto":
			out.print("<div class='alert alert-danger'>Usuário ou Senha incorretos.</div>");
			break;
		case "sair":
			out.print("<div class='alert alert-success'>Sessão encerrada com sucesso.</div>");
			break;
		case "usuarioCriado":
			out.print("<div class='alert alert-success'>Conta criada com sucesso.</div>");
			break;
		case "dadosIncorretos" :
			out.print("<div class='alert alert-danger'>E-mail ou senha incorretos!</div>");
			break;
		case "produtoCadastrado" :
			out.print("<div class='alert alert-success'>Produto Cadastrado!</div>");
			break;
		case "produtoFalha" :
			out.print("<div class='alert alert-danger'>Falha ao cadastrar o produto.</div>");
			break;
		case "produtoExcluido" :
			out.print("<div class='alert alert-success'>Produto excluido com sucesso.</div>");
			break;
		case "produtoExcluidoFalha" :
			out.print("<div class='alert alert-danger'>Falha ao excluir o produto.</div>");
			break;
		case "produtoAlterado" :
			out.print("<div class='alert alert-success'>Produto alterado com sucesso.</div>");
			break;
		case "produtoAlteradoFalha" :
			out.print("<div class='alert alert-danger'>Falha ao alterar o produto.</div>");
			break;
		}
	} catch (Exception erro) {
	}
%>