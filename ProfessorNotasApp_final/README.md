# ProfessorNotasApp - Versão Atualizada (Scaffold)

Esta é uma versão **atualizada e simplificada** do seu projeto, com melhorias:
- UI usando Material components (mais moderno)
- Estrutura básica estilo MVVM com Room (local DB)
- Dashboard com resumo, export CSV
- RecyclerView com cards para cada aluno
- Atividades: Dashboard, Lista de Alunos, Adicionar Aluno

Como usar:
1. Descompacte este diretório.
2. Abra o Android Studio e escolha **File > Open** apontando para a pasta `ProfessorNotasApp_updated`.
3. Aguarde o Gradle configurar. Em seguida, **Build > Build APK(s)**.
4. O APK será gerado (ou corrija pequenos imports caso o Android Studio peça ajustes).

Observações:
- Este é um scaffold / base pronta. Integração com Firebase, autenticação e export para PDF podem ser adicionadas posteriormente.
- Arquivo gerado CSV fica em `filesDir/notas_export.csv` após uso do botão Exportar.
