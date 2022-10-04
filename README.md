# boleto

Para Utilizar o projeto execute os seguintes passos:

execute o clone do projeto
abra o projeto com a uma IDE, sugiro o Intelij
execute o maven clean, install
execute o run clicando com o botao direito em cima da classe TesteAplication
instale o Postmam em sua máquina
abra o postmam 
utilize a url localhost:8080/calcularJuros via POST
passe dentro da body da rquisição o seguinte JSON
{
    "bar_code":"34191790010104351004791020150008191070069000",
    "payment_date":"2021-10-01T09:45:00.000+02:00"
}
