# AluraFlix
API AluraFlix tem como finalidade retornar dados , no formato JSON, mediante requisições aos end point aqui listados no padrão REST. Os principais consumidores desses serviços serão aplicações front-end web ou mobile.

# Visão Geral
A API faz parte do programa Aluraflix, idealizado pela Alura, destinado ao estudo e implementação de um serviço backend da plataforma de vídeo da Alura, ou seja um serviço de API REST. Têm como objetivos explorar as diversas etapas envolvidas na criação  e implementação de uma API REST.
Este projeto foi desenvolvido utilizando a linguagem Java e o framework Spring (Boot, Data, Security e Web). A camada de persistência utiliza banco de dados MariaDb / MySQL nos ambientes de dev/prod e o banco em memória H2 para os testes de integração.

Os principais recursos implementados são:
* Aplicação Stateless 
* Validação de dados de entrada
* Paginação
* Persistência de dados em banco de dados relacional SQL
* Autenticação auth para obtenção de token
* Autenticação via token para consumo das requisições REST
* End point público sem necessidade de autenticação
* CRUD via end point
* Testes automatizados de unidade e integração
* Ambientes distintos para Test, Dev e Prod
* Deploy da aplicação em cloud computer Oracle
* Tratativa de erros personalizados 

Documentação da API disponível em https://documenter.getpostman.com/view/6125281/TzsZrTiX
