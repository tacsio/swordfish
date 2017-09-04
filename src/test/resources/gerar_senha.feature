#language: pt
Funcionalidade: Gerar Senha
  Como um usuário
  Eu quero gerar automáticamente senhas de acordo com determinadas especificidades
  Para utilizar essas senhas em meus diversos aplicativos

  Esquema do Cenário: Gerar Senha
    Dado que o usuário acessou a página
    Quando o nome do usuário é <nome>
    E A dia de nascimento é <dia_nasc>
    E o tamanho da senha é <tamanho>
    E a opção de letras maiúscula é <maiuscula>
    E a opção de repetição de números é <repeticao>
    E a opção de caracteres especiais é <caractere_especial>
    E o tipo da senha selecionada é <tipo>
    Então O site mostra três possibilidades de senha
    E as senhas estão válidas de acordo com as opções selecionadas

    Exemplos: 
      | nome       | dia_nasc | tamanho | maiuscula     | repeticao     | caractere_especial | tipo           |
      | "Tarcisio" |       28 |       8 | "não marcada" | "marcada"     | "marcada"          | "numérica"     |
      | "Mariane"  |        2 |      10 | "marcada"     | "não marcada" | "não marcada"      | "alfabética"   |
      | "Hially"   |        1 |       6 | "não marcada" | "não marcada" | "não marcada"      | "alfanumérica" |
