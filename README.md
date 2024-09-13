# Jogo Pong em Java 🎮

Este projeto é uma recriação clássica do jogo **Pong** desenvolvido em Java. Ele permite que dois jogadores se enfrentem em uma partida de Pong, controlando raquetes e tentando marcar pontos. O projeto foi desenvolvido como parte de um trabalho acadêmico e tem como objetivo demonstrar a implementação de gráficos em tempo real e manipulação de eventos no Java Swing.

## Funcionalidades

- Controle de duas raquetes por dois jogadores, um usando as teclas `W` e `S`, e o outro utilizando as setas direcionais `↑` e `↓`.
- Movimento e colisão da bola com as raquetes e as bordas da tela.
- Pontuação dos jogadores exibida na tela.
- Botão para reiniciar a bola caso ela fique presa.
- Interface gráfica simples e funcional com `Java Swing`.

## Estrutura de Classes

### 1. `Ball.java`
Define o comportamento da bola, incluindo sua movimentação, direção e colisões com as raquetes e as bordas da tela.

### 2. `Paddle.java`
Representa as raquetes dos jogadores, permitindo o controle por teclado e movimentação suave.

### 3. `GamePanel.java`
Painel principal do jogo onde ocorrem as animações e colisões entre a bola e as raquetes.

### 4. `GameFrame.java`
Janela principal do jogo, contendo o painel de jogo e o botão de reinício da bola.

### 5. `Score.java`
Responsável por exibir a pontuação de ambos os jogadores na tela.

### 6. `PongGame.java`
Classe principal que inicia o jogo.

## Como Executar

### Passos para iniciar o jogo:

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seuusuario/pong-game-java.git
