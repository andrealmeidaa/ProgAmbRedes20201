import socket

host='127.0.0.1' #Host onde o socket vai ser executado, no caso localhost
port=5000 #Porta para receber a conexão

mSocket=socket.socket() #Instancia um socket
mSocket.bind((host,port)) #No socket TCP, realizamos bind do host/porta, passando uma lista Python
mSocket.listen(1) #O socket começa a "ouvir" requisições, com no máximo 01 conexão
print("Aguardando conexão")
conexao,enderecoCliente=mSocket.accept() #Aceita a conexão, informando de onde veio a requisição(ip). Aqui o processo fica parado
print("Conexando vinda de "+str(enderecoCliente))
while True:
    dados=conexao.recv(1024).decode() #Recebe no máximo 1024 bytes e realiza o decode para string
    if not dados: #Se a conexão do cliente for encerrada, encerra o servidor
        break
    print("Mensagem recebida: "+dados)
    
    dados=dados.upper()+" - do servidor"
    print("Enviando: "+dados)
    conexao.send(dados.encode()) #Devolve resposta ao cliente
conexao.close() #Fecha a conexao