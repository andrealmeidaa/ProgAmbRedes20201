import requests #Importa a biblioteca requests

POST_LOGIN_URL='http://httpbin.org/post' #Url de submissão

username=input("Usuário:")
senha=input("Senha:")
dados={'Name':username,'Password':senha} #Monta os dados da requisição post
response=requests.post(POST_LOGIN_URL,data=dados) #submete a requisição
print(response.text) #Exibe o conteúdo da resposta
print(str(response.status_code)+' - ' +response.reason) #Exibe o código de retorno e a mensagem