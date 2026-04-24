package connect4.gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import connect4.Connector;
import connect4.response.NewGameResponse;
import connect4.response.Util;

public class Connect4 extends JFrame
{
    private static final long serialVersionUID = 1L;
    private Connector connector;

    //TODO: pick your own username
    private String user = "spacco";
    // TODO: comment out localhost and use euclid on campus
    // remember localhost means your current computer, and if
    // you don't have a server running on your computer then
    // nothing will work
    //private String server = "http://localhost:8080/connect4";
    private String server = "http://euclid.knox.edu:8083/connect4";

    public Connect4() {
        super("Connect 4");
        connector = new Connector(server, user);
        
        // probably need a grid layout manager of the 7x6 grid?
        //setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);

        createMenuBar();

        setVisible(true);
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem newGame = new JMenuItem("New Game");
        fileMenu.add(newGame);
        
        newGame.addActionListener(e -> {
            NewGameResponse newGameResponse = connector.newGame();
            System.out.println(newGameResponse.toString());
            // popup a window with the board
            JOptionPane.showMessageDialog(null, Util.boardToString(newGameResponse.board));
        });

        // add edit menu containing a settings item that creates a settings panel
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        JMenuItem settings = new JMenuItem("Settings");
        editMenu.add(settings);


       settings.addActionListener(e -> {
            // just generate an error
            JOptionPane.showMessageDialog(
                null, // parent component (null centers on screen)
                "Pretend an error happened",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
       });

    }


    public static void main(String[] args) {
        new Connect4();
    }

}