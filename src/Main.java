import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Main extends JFrame implements KeyListener {
    boolean didRed = false;
    boolean didGreen = false;
    boolean didBlue = false;
    boolean didRedGreen = false;
    boolean didRedBlue = false;
    boolean didGreenBlue = false;
    boolean didRedGreenBlue = false;

    String[] moveStartPos = {"LEFT", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT"};
    String[] loop = {"UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",
            "RIGHT",
            "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP",
            "RIGHT",
            "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN",


            "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT"
    };
    boolean atStartPos = false;
    int progress = 0;
    private BufferedImage image;
    private JPanel panel;
    private final int[][] defSnake = {{500, 300}, {500, 325}};

    int[][] snake = defSnake;

    int[] food;
    public static int width = 1000;
    public static int height = 700;
    private String dir = "UP";
    private String nextDir = "UP";

    public Main() {
        super("Snake");
        setSize(width+25, height+25);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        snake = defSnake;
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        panel.setBackground(Color.DARK_GRAY);
        add(panel);

        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // go
                if (!atStartPos) {
                    nextDir = moveStartPos[progress];
                    progress++;
                    if (progress == moveStartPos.length) {
                        atStartPos = true;
                        progress = 0;
                    }
                } else {
                    nextDir = loop[progress];
                    progress++;
                    if (progress == loop.length) {
                        progress = 0;
                    }
                }

                // Spawn the food if not already present
                if (food == null) {
                    do {
                        food = getRPos();
                    } while (isPositionInSnake(food));
                }

                // Move the snake
                dir = nextDir;
                int[] head = new int[2];
                head[0] = snake[0][0];
                head[1] = snake[0][1];

                switch (dir) {
                    case "UP":
                        head[1] -= 25;
                        break;
                    case "DOWN":
                        head[1] += 25;
                        break;
                    case "RIGHT":
                        head[0] += 25;
                        break;
                    case "LEFT":
                        head[0] -= 25;
                        break;
                }

                int[][] newSnake;
                if (head[0] == food[0] && head[1] == food[1]) {
                    // If the snake eats the food, increase the length by 1
                    newSnake = new int[snake.length + 1][2];
                    newSnake[0] = head;
                    System.arraycopy(snake, 0, newSnake, 1, snake.length);
                    snake = newSnake;
                    food = null; // Food should disappear after being eaten
                    System.out.println(snake.length);
                    if (snake.length == 1120) {
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                        System.out.println("IT WON");
                    }
                } else {
                    // Otherwise, keep the length the same
                    newSnake = new int[snake.length][2];
                    newSnake[0] = head;
                    System.arraycopy(snake, 0, newSnake, 1, snake.length - 1);
                    snake = newSnake;
                }

                // Collision detection
                head = snake[0];
                for (int i = 1; i < snake.length; i++) {
                    if (head[0] == snake[i][0] && head[1] == snake[i][1]) {
                        System.out.println("GAME OVER");
                        snake = defSnake;
                        dir = "UP";
                        break;
                    }
                }

                // Out-of-bounds detection
                if (head[0] >= width || head[1] >= height || head[0] < 0 || head[1] < 0) {
                    System.out.println("GAME OVER");
                    snake = defSnake;
                    dir = "UP";
                }

                // Clear the image first
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(Color.DARK_GRAY);
                g2d.fillRect(0, 0, image.getWidth(), image.getHeight());

                // Draw the food
                if (food != null) {
                    g2d.setColor(Color.RED);
                    g2d.fillRect(food[0], food[1], 25, 25);
                }

                // Draw the snake
                for (int i = 0; i < snake.length; i++) {
                    if (i > 255) {
                        if (i > 510) {
                            Color color = new Color(510-i, 510-i, i-510);
                            g2d.setColor(color);
                            g2d.fillRect(snake[i][0], snake[i][1], 25, 25);
                        } else {
                            Color color = new Color(255-i, i-255, 0);
                            g2d.setColor(color);
                            g2d.fillRect(snake[i][0], snake[i][1], 25, 25);
                        }
                    } else {
                        Color color = new Color(i, 0, 0);
                        g2d.setColor(color);
                        g2d.fillRect(snake[i][0], snake[i][1], 25, 25);
                    }
                }

                g2d.dispose();
                panel.repaint();
            }
        });

        timer.start();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main main = new Main();
            main.setVisible(true);
        });
    }

    public static int[] getRPos() {
        int[] pos;
        int maxX = (width / 25);
        int maxY = (height / 25);
        int posX = (int) (Math.random() * maxX);
        int posY = (int) (Math.random() * maxY);
        pos = new int[]{posX * 25, posY * 25};
        return pos;
    }

    public boolean isPositionInSnake(int[] pos) {
        return Arrays.stream(snake).anyMatch(part -> Arrays.equals(part, pos));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            atStartPos = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}