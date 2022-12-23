## FEUP-LDTS-PROJ
Este trabalho realizado por João Pedro Rodrigues Coutinho (up202108787), Joaquim Afonso Marques da Cunha (up202108779) e Miguel Jorge Medeiros Garrido (up202108889) tem como objetivo a realização do projeto da disciplina "Laboratório de Desenho e Teste de Software" (L.EIC014) onde nos foi proposto a realização de um text-based game em Java. 
Para tal tivemos como ideia um jogo do género RPG (role-playing game) onde o personagem tem de explorar e coletar "gold" para se fortalecer e enfrentar diversos oponentes e desafios durante a sua jornada.

Exemplos jogo:
  
        ![image](https://user-images.githubusercontent.com/93836408/209408623-715919f9-513c-4546-9103-4c3ebbac728f.png)
        
        
                
        ![image](https://user-images.githubusercontent.com/93836408/209408727-abb6b5a3-d8e7-441c-9414-debdfc94a90c.png)
        
        
        
        ![image](https://user-images.githubusercontent.com/93836408/209408782-c69aa4cc-2576-43ba-81f2-90552182d9f2.png)

        
        ![image](https://user-images.githubusercontent.com/93836408/209408980-7d8ddb3e-1c7a-4dc2-b191-36215b4407cc.png)


        


### IMPLEMENTED FEATURES
- **fight** - O player defronta um inimigo e consoante o resultado este morre ou ganha uma recompensa deixada pelo adversário além de alguma perda de pontos de vida;  
- **loot** - O player recolhe a recompensa do inimigo em caso de vitoria;  
- **shop** - O player tem a possibilidade de utilizar o seu gold em troca de items que o fortalecem;

```java
public int buyItem(Player player, String itemName, boolean dup) {
        for(Item item: items) {
            if(item.getName().equals(itemName) &&
                    ((player.getGold() >= item.getValue() && !dup) ||
                            (player.getGold() >= item.getValue()*2 && dup))) {
                player.addItem(item);
                int spent = -1;
                if(dup) {
                    spent = item.getValue() * 2;
                    player.setGold(player.getGold() - spent);
                }
                else {
                    spent = item.getValue();
                    player.setGold(player.getGold() - spent);
                }
                items.remove(item);
                return spent;
            }
        }
        return -1;
    }
```

```java
public void loot(Player player) {
        player.setGold(player.getGold() + gold);
    }
```

```java
public boolean fight(Player player) {
        Random rand = new Random();
        int num_enemy;
        if(enemies.size() == 1)
            num_enemy = 0;
        else
            num_enemy = rand.nextInt(enemies.size() - 1);
        int player_total_atk = enemies.get(num_enemy).getHp() / player.getDamage();
        int enemy_total_atk = player.getHp() / enemies.get(num_enemy).getDamage();
        if(player_total_atk > enemy_total_atk)
            return false;
        player.setHp(player.getHp() - player_total_atk * enemies.get(num_enemy).getDamage());
        enemies.get(num_enemy).loot(player);
        enemies.remove(num_enemy);
        return true;
    }
```


### PLANNED FEATURES
- **Raridade items** - Towns com lojas com items que apesar de mais caros são raros e mais fortes
- **Lista Items Default** - List de items default onde os items podem ou não ser alterada consoante o comportamento da Town (mudança de preço e/ou raridade)
- **Lista Ascii Art** - Ficheiro txt com todas as artes que vão ser utilizadas no jogo que será importado como uma lista
- **States, Controllers, Viewers** - Base restante ao programa que irá comunicar entre si e o Model
- **Decisões Player** - Capacidade de escolha de tentativa de fuga de uma luta
- **Novos locais Town** - Locais onde pode interagir de mais diversas formas como por exemplo melhorar o armamento


### DESIGN
#### DIFERENTES "TOWNS" TEM LOJAS COM PREÇOS DIFERENTES
**Problem in Context**
Decidimos que, baseado em vários rpgs, nem todas as Towns deveriam apresentar os mesmos valores de preços e raridade. Com isso, ao invés de os alterar diretamente no construtor decidimos implementar o strategy pattern para melhorar a leitura e possiveis adições de outras estratégias. Conseguimos assim tornar o nosso código mais flexível a mudanças de comportamento no que diz respeito as caracteristicas dos items. 

**The Pattern**
Para isto decidimos usar o **Strategy** pattern. Este permite-nos que classes difiram apenas no seu comportamento e que consiga ser alterado em "run time". Neste design pattern conseguimos alterar facilmente o comportamento de um objeto consoante a strategy. Este pattern facilitou-nos a resolução do nosso problema, pois conseguimos alterar o comportamento de uma Town, tornando mais interativa as lojas ao apresentarem diferentes preços ao player

**Implementation**

![image](https://user-images.githubusercontent.com/93836408/204079847-0df94821-a0a9-4f4b-993a-562486438b83.png)

**Consequences**
O uso do Strategy Pattern traz os seguintes benifícios:
- Permite que as Towns se diferenciem em termos de custo e raridade;
- Fornece diferentes implementações e facilita novas que sejam desejadas no futuro;
- Reduz o número de condições que teriam de ser utilizadas através do encapsulamento dos comportamentos em cada classe e do uso de polimorfismo;


#### EXISTEM DIFERENTES CATEGORIAS DE ITEMS
**Problem in Context**
Consideramos que os items deveriam ser rotulados consoante o seu tipo, pois estes podiam ter diferentes responsabilidades e atributos. Optamos assim por utilizar o factory method pattern nos items que melhora a leitura e a manutenção de código como também facilita a adição ou remoção de algum tipo num futuro ou noutra fase do jogo.

**The Pattern**
Como referido em cima utilizamos o **Factory Method** patern. Com este design pattern damos liberdade à subclasse de decidir qual quer instanciar através de uma interface ou de uma classe abstrata. Conseguimos com isto, também, esconder a lógica, da criação dos objetos, do cliente.

**Implementation**

![image](https://user-images.githubusercontent.com/93836408/204081445-4f4a9e5e-ef5d-4a82-a377-ab9f3e656b69.png)

**Consequences**
- Facilidade na reutilização de código
- Promove o Loose Coupling
- Aumenta o numero de classes utilizadas


### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS
Nada encontrado até então ainda que consideremos que possámos a vir a alterar muitas estratégias ao longo do desenvolvimento.

### TESTING
![image](https://user-images.githubusercontent.com/93836408/204087956-ef296a17-c8eb-4d71-a0dd-321a06c26d4b.png)





### SELF-EVALUATION
João Coutinho 33%
Joaquim Cunha 33%
Miguel Garrido 33%



