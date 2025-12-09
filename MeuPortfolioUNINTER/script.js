document.addEventListener('DOMContentLoaded', function() {
    
    // ------------------------------------------------------------------
    // 1. Menu Responsivo (Interação Simples)
    // ------------------------------------------------------------------
    const menuToggle = document.querySelector('.menu-toggle');
    const menuLinks = document.getElementById('menu-links');

    if (menuToggle && menuLinks) {
        menuToggle.addEventListener('click', function() {
            menuLinks.classList.toggle('ativo'); 
            const isExpanded = menuToggle.getAttribute('aria-expanded') === 'true' || false;
            menuToggle.setAttribute('aria-expanded', !isExpanded);
        });
    }

    // ------------------------------------------------------------------
    // 2. Validação e Simulação de Envio do Formulário (Requisito Obrigatório)
    // ------------------------------------------------------------------
    
    const form = document.getElementById('formContato');
    const feedback = document.getElementById('feedbackMensagem');

    // COMENTÁRIO EXPLICATIVO: Verifica se a página de contato está sendo carregada.
    if (form) {
        // COMENTÁRIO EXPLICATIVO: Adiciona um ouvinte para o evento de submissão do formulário.
        form.addEventListener('submit', function(event) {
            // Impede que a página recarregue ao submeter o formulário
            event.preventDefault();

            // Pega os valores e remove espaços em branco no início/fim
            const nome = document.getElementById('nome').value.trim();
            const email = document.getElementById('email').value.trim();
            const mensagem = document.getElementById('mensagem').value.trim();

            // COMENTÁRIO EXPLICATIVO: Função para validar o formato do e-mail (requisito obrigatório).
            function validarEmail(email) {
                // Expressão Regular que verifica o padrão básico: texto@texto.texto
                const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                return re.test(String(email).toLowerCase());
            }

            // 3. Validação: Checagem de campos vazios (Requisito obrigatório)
            if (nome === '' || email === '' || mensagem === '') {
                feedback.textContent = 'Erro: Por favor, preencha todos os campos.';
                feedback.style.color = 'red';
                // COMENTÁRIO EXPLICATIVO: Se falhar na validação, o script para aqui.
                return; 
            } 
            
            // 4. Validação: Checagem do formato do e-mail (Requisito obrigatório)
            if (!validarEmail(email)) {
                feedback.textContent = 'Erro: O e-mail fornecido não possui um formato válido (ex: nome@dominio.com).';
                feedback.style.color = 'red';
                return;
            }

            // 5. Simulação de Envio (Validação bem-sucedida)
            
            // Limpa os campos do formulário (Requisito obrigatório)
            form.reset(); 

            // Exibe a mensagem de sucesso (Requisito obrigatório)
            feedback.textContent = 'Mensagem enviada com sucesso! Em breve, entrarei em contato.';
            feedback.style.color = 'green';
            
            // Opcional: Limpa a mensagem após 5 segundos
            setTimeout(() => {
                feedback.textContent = '';
            }, 5000);
        });
    } 
});