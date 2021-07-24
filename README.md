# AluraFlix
Implementação de API REST para o programa Alura Challenge Back-End.


## Listar todos os videos 
  **Tipo de Requisição:** GET
  
  **URL:** http://ip_servidor/videos
  
  Exemplo de resposta:
  ```
  [
    {
        "id": 1,
        "titulo": "O programador que queria ajudar as pessoas: Samuel Pimentel",
        "descricao": "A história de um cara que já formatou muito PC, teve um pet shop, quase foi jogador profissional de League of Legends e se encontoru na tecnologia.",
        "url": "https://www.youtube.com/watch?v=-C5P1Csd5qk"
    },
    {
        "id": 2,
        "titulo": "Grupo de Estudos - Casa do Código - Métricas Ágeis com Raphael Albino",
        "descricao": "Conversar com o Raphael Albino, autor do livro  \"Métricas ágeis: ",
        "url": "https://www.youtube.com/watch?v=BFYGFZf91tQ"
    }
  ]
  ```

  ## Lista um vídeo pelo id
  **Tipo de Requisição:** GET
  
  **URL:** http://ip_servidor/videos/{id}
  
  Exemplo de Resposta:
  ```
   [
    {
        "id": 5,
        "titulo": "Título do vídeo",
        "descricao": "Descrição do vide",
        "url": "https://www.link_do_video.com.br"
    }
   ]
  ```
  ## Adiciona um vídeo
  **Tipo de Requisição:** POST 
  
  **URL:** http://ip_servidor/videos/
  ```
  {
      "titulo": "Titulo do Video ",
      "descricao": "Descrição do video ",
      "url": "https://www.link_do_video.com.br"
  }
  ```
  Exemplo de Resposta:
  
  Head:
  ```
    Locatio : http://ip_servidor/videos/33
  ```  
  Body
  ```
  {
      "id": 33
      "titulo": "Titulo do Video ",
      "descricao": "Descrição do video ",
      "url": "https://www.link_do_video.com.br"
    }
  ```
  ## Atualizar dados de um vídeo existente
  **Tipo de Requisição:** PUT 
  
  **URL:** http://ip_servidor/videos/{id}
  ```
  {
      "titulo": "Titulo do Video Atualizado",
      "descricao": "Descrição do video ",
      "url": "https://www.link_do_video.com.br"
  }
  ```
  OBS: Todos os campos devem ser preenchido, no envio da chamada. 

  Exemplo de Resposta:
  ```
  {
      "titulo": "Titulo do Video Atualizado",
      "descricao": "Descrição do video ",
      "url": "https://www.link_do_video.com.br"
  }
  ```  
  ## Remover um vídeo pelo id
  **Tipo de Requisição:** DELETE
  
  **URL:** http://ip_servidor/videos/{id}
