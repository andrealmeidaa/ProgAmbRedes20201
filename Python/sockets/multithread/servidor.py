import socket, threading

class ClienteThread(threading.Thread):
    def __init__(self,enderecoCliente,socketCliente):
        threading.Thread.__init__(self)
        self.csocket=socketCliente
        self.enderecoCliente=enderecoCliente
        print("Conexão recebido de ",enderecoCliente)
    def run(self):
        mensagem=''
        contMensagem=0
        while True:
            dados=self.csocket.recv(1024)
            mensagem=dados.decode()
            if (not mensagem):
                break
            print("Recebi de ",self.enderecoCliente," a mensagem: ",mensagem)
            contMensagem+=1
            mensagemRetorno="Tudo ok pela "+str(contMensagem)+" vez."
            self.csocket.send(mensagemRetorno.encode())
        print("Cliente ", self.enderecoCliente, " Desconectado")
HOST='127.0.0.1'
PORT=2345
servidor=socket.socket(socket.AF_INET,socket.SOCK_STREAM)
servidor.setsockopt(socket.SOL_SOCKET,socket.SO_REUSEADDR,1) #Permit reusar o endereço
servidor.bind((HOST,PORT))
print("Aguardando Conxões")
while True:
    servidor.listen(1)
    clienteSocket,enderecoCliente=servidor.accept()
    thread_cliente=ClienteThread(enderecoCliente,clienteSocket)
    thread_cliente.start()