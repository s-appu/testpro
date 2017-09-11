package test.nestedClasses;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ListenerTest {

    public static void main( final String args[] ) {
        final JButton testButton = new JButton( "Test Button" );
        testButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( final ActionEvent e ) {
                System.out.println( "Click Detected by anonymous class" );
            }
        } );

        testButton.addActionListener( e -> System.out.println( "Click detected by lambda" ) );

        final JFrame frame = new JFrame( "Listener Test" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( testButton, BorderLayout.CENTER );
        frame.pack();
        frame.setVisible( true );
    }
}
