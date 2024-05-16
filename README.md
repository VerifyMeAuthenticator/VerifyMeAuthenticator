# VerifyMeAuthenticator
Componente de autenticação com ótima funcionalidade.
# Funcionalidades do projeto

- `Registro de Usuários`:  Os usuários podem se registrar fornecendo um nome de usuário único e uma senha. As credenciais são armazenadas em memória.
- `Autenticação de Usuários`: Os usuários podem fazer login fornecendo seu nome de usuário e senha. O sistema verifica se as credenciais correspondem às armazenadas em memória.
- `Recuperação de Senha`: Os usuários podem solicitar a recuperação de senha fornecendo seu nome de usuário ou e-mail. Um e-mail de recuperação é enviado com instruções para redefinir a senha.
- `Redefinição de Senha`: Os usuários podem redefinir sua senha seguindo o link enviado por e-mail. Eles fornecem uma nova senha que substitui a anterior no armazenamento em memória.
- `Políticas de Senha` : Implemente políticas de senha, como comprimento mínimo, caracteres especiais necessários e expiração de senha.
- `Expiração de Sessão` : Garanta que as sessões de login tenham um tempo de expiração para melhorar a segurança.
- `Bloqueio de Conta`: Implemente uma política de bloqueio de conta após várias tentativas de login malsucedidas para evitar ataques de força bruta.
- `Integração com Aplicações` : Forneça uma interface de integração simples para aplicativos que desejam usar o componente de autenticação.
