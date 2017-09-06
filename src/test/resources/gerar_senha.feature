#language: pt
Funcionalidade: Gerar Senha
  Como um usuário
  Eu quero gerar automáticamente senhas de acordo com determinadas especificidades
  Para utilizar essas senhas em meus diversos aplicativos

  Esquema do Cenário: Gerar Senha
    Dado que o usuário acessou a página
    Quando o nome do usuário é <nome>
    E o dia de nascimento é <dia_nasc>
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
      | ""         |        0 |       3 | "não marcada" | "não marcada" | "não marcada"      | "alfanumérica" |

  Cenário: Gerar senha sem preencher tamanho
    Dado que o usuário acessou a página
    Quando o nome do usuário é "Fulano"
    E o dia de nascimento é 30
    E o tamanho da senha é vazio
    E a opção de letras maiúscula é "marcada"
    E a opção de repetição de números é "marcada"
    E a opção de caracteres especiais é "marcada"
    E o tipo da senha selecionada é "numérica"
    Então O site mostra a mensagem de erro: "O campo de tamanho de senha deve ser preenchido."

  Cenário: Gerar senha com tamanho menor que o mínimo
    Dado que o usuário acessou a página
    Quando o nome do usuário é "Fulano"
    E o dia de nascimento é 30
    E o tamanho da senha é 2
    E a opção de letras maiúscula é "marcada"
    E a opção de repetição de números é "marcada"
    E a opção de caracteres especiais é "marcada"
    E o tipo da senha selecionada é "numérica"
    Então O site mostra a mensagem de erro: "Informe um tamanho de senha entre 5 e 10."

  Esquema do Cenário: Gerar Senha com configurações incompatíveis
    Dado que o usuário acessou a página
    Quando o nome do usuário é <nome>
    E o dia de nascimento é <dia_nasc>
    E o tamanho da senha é <tamanho>
    E a opção de letras maiúscula é <maiuscula>
    E a opção de repetição de números é <repeticao>
    E a opção de caracteres especiais é <caractere_especial>
    E o tipo da senha selecionada é <tipo>
    Então O botão de gerar é desabilitado
    E O site mostra a mensagem de erro: <msg_erro>

    Exemplos: 
      | nome       | dia_nasc | tamanho | maiuscula | repeticao | caractere_especial | tipo         | msg_erro                                                                      |
      | "Tarcisio" |       28 |       8 | "marcada" | "marcada" | "marcada"          | "numérica"   | "Não é possível gerar uma senha do tipo numérica com letras maiúsculas."      |
      | "Tarcisio" |       28 |       8 | "marcada" | "marcada" | "marcada"          | "alfabética" | "Não é possível gerar uma senha do tipo alfabética com repetição de números." |
