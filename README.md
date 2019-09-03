# catalogue-ms-security
Cette  application web JEE  permet des gérer des produits classés par catégories :

- La partie Backend est basée sur deux micro-services : 
     - Un micro-service basé sur Spring IOC, Spring Data, Spring Data Rest, Spring Security JPA, Hibernate qui permet de gérer les produits et les catégories. Dans ce micro-service, les produits et les catégories sont stockés dans une base de données NoSQL MongoDB.
      - Un micro-service d’authentification qui s'occupe de la partie sécurité basée sur Spring Security et Json Web Token (JWT). Dans ce micro-service, les utilisateurs et les rôles sont stockés dans une base de données SQL (H2 ou MySQL). 
