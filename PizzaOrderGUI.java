import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaOrderGUI extends JFrame implements ActionListener {

    private JComboBox<String> pizzaBox;
    private JTextArea cartArea;
    private JButton addButton, checkoutButton, clearButton, viewCartButton;
    private List<String> cart = new ArrayList<>();

    public PizzaOrderGUI() {
        // Frame setup
        setTitle("🍕 Java Pizza Ordering System");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("🍕 Welcome to Java Pizza!", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        // Pizza selection
        JPanel topPanel = new JPanel();
        pizzaBox = new JComboBox<>(new String[]{
                "Margherita - ₹199",
                "Farmhouse - ₹249",
                "Peppy Paneer - ₹279",
                "Veg Extravaganza - ₹299"
        });
        addButton = new JButton("Add to Cart");
        addButton.addActionListener(this);
        topPanel.add(pizzaBox);
        topPanel.add(addButton);
        add(topPanel, BorderLayout.CENTER);

        // Cart area
        cartArea = new JTextArea(10, 30);
        cartArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(cartArea);
        add(scrollPane, BorderLayout.SOUTH);

        // Buttons panel at the bottom
        JPanel bottomPanel = new JPanel();
        checkoutButton = new JButton("Checkout");
        clearButton = new JButton("Clear Cart");
        viewCartButton = new JButton("View Cart");

        checkoutButton.addActionListener(this);
        clearButton.addActionListener(this);
        viewCartButton.addActionListener(this);

        bottomPanel.add(checkoutButton);
        bottomPanel.add(clearButton);
        bottomPanel.add(viewCartButton);

        add(bottomPanel, BorderLayout.PAGE_END);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String pizza = (String) pizzaBox.getSelectedItem();
            cart.add(pizza);
            cartArea.append(pizza + "\n");
        } else if (e.getSource() == checkoutButton) {
            if (cart.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Cart is empty!");
            } else {
                double total = 0;
                for (String item : cart) {
                    if (item.contains("199")) total += 199;
                    else if (item.contains("249")) total += 249;
                    else if (item.contains("279")) total += 279;
                    else if (item.contains("299")) total += 299;
                }
                JOptionPane.showMessageDialog(this,
                        "Order placed!\nTotal Amount: ₹" + total,
                        "Checkout", JOptionPane.INFORMATION_MESSAGE);
                cart.clear();
                cartArea.setText("");
            }
        } else if (e.getSource() == clearButton) {
            cart.clear();
            cartArea.setText("");
        } else if (e.getSource() == viewCartButton) {
            if (cart.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Your cart is empty.");
            } else {
                StringBuilder cartContents = new StringBuilder();
                for (String item : cart) {
                    cartContents.append(item).append("\n");
                }
                JOptionPane.showMessageDialog(this, cartContents.toString(), "Your Cart", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PizzaOrderGUI frame = new PizzaOrderGUI();
            frame.setVisible(true);
        });
    }
}
