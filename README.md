## LPOO_<2><1>
Este trabalho realizado por João Pedro Rodrigues Coutinho (up202108787), Joaquim Afonso Marques da Cunha (up202108779) e Miguel Jorge Medeiros Garrido (up202108889) tem como objetivo a realização do projeto da disciplina "Laboratório de Desenho e Teste de Software" (L.EIC014) onde nos foi proposto a realização de um text-based game em Java. 
Para tal tivemos como ideia um jogo do género RPG (role-playing game) onde o personagem tem de explorar e coletar "gold" para se fortalecer e enfrentar diversos oponentes e desafios durante a sua jornada.


### IMPLEMENTED FEATURES
- **fight** - O player defronta um inimigo e consoante o resultado este morre ou ganha uma recompensa deixada pelo adversário além de alguma perda de pontos de vida;  
- **loot** - O player recolhe a recompensa do inimigo em caso de vitoria;  
- **shop** - O player tem a possibilidade de utilizar o seu gold em troca de items que o fortalecem;
![image](https://user-images.githubusercontent.com/93836408/204077928-7887bc97-78c4-42b4-8bb4-1fe1a1caa3af.png)
![image](https://user-images.githubusercontent.com/93836408/204077965-3bb9b8c3-7237-4ef7-94a9-fdb84766a57a.png)


### PLANNED FEATURES
- **


### DESING
#### DIFERENTES "TOWNS" TEM LOJAS COM PREÇOS DIFERENTES
**Problem in Context**
Decidimos que, baseado em vários rpgs, nem todas as Towns deveriam apresentar os mesmos valores de preços. Com isso, ao invés de alterar os preços diretamente no construtor decidimos implementar o strategy pattern para melhorar a leitura e possiveis adições de outras estratégias. Conseguimos assim tornar o nosso código mais flexível a mudanças de comportamento no que diz respeito ao custo dos items. 

**The Pattern**
Para isto decidimos usar o **Strategy** pattern. Ester permite-nos que classes difiram apenas no seu comportamento e que consiga ser alterado em "run time". Neste design pattern conseguimos alterar facilmente o comportamento de um objeto consoante a strategy. Este pattern facilitou-nos a resolução do nosso problema, pois conseguimos alterar o comportamento de uma Town, tornando mais interativa as lojas ao apresentarem diferentes preços ao player

**Implementation**
![image](https://user-images.githubusercontent.com/93836408/204079847-0df94821-a0a9-4f4b-993a-562486438b83.png)

**Consequences**
O uso do Strategy Pattern trouxe os seguintes benifícios:
- Permitiu que as Towns se diferenciassem em termos de custo;
- Fornece diferentes implementações e facilita novas que sejam desejadas no futuro;
- Reduziu o número de condições que teriam de ser utilizadas através do encapsulamento dos comportamentos em cada classe e do uso de polimorfismo;


#### EXISTEM DIFERENTES CATEGORIAS DE ITEMS
factory method patern



### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS


### TESTING



### SELF-EVALUATION
João Coutinho 33%
Joaquim Cunha 33%
Miguel Garrido 33%

