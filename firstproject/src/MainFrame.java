import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTextField campoNome;
    private JPasswordField campoSenha;
    private JRadioButton radioMasculino, radioFeminino;
    private JCheckBox checkEspanhol, checkIngles, checkItaliano;
    private JComboBox<String> comboNivel;
    private JTextArea areaComentarios;
    private JButton botaoEnviar, botaoSair;

    public MainFrame() {
        setTitle("Formulário");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(7, 1, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelNome = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNome.add(new JLabel("Nome:"));
        campoNome = new JTextField(20);
        panelNome.add(campoNome);
        panelPrincipal.add(panelNome);

        JPanel panelSenha = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelSenha.add(new JLabel("Senha:"));
        campoSenha = new JPasswordField(20);
        panelSenha.add(campoSenha);
        panelPrincipal.add(panelSenha);

        JPanel panelGenero = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelGenero.add(new JLabel("Gênero:"));
        
        radioMasculino = new JRadioButton("Masculino", true); 
        radioFeminino = new JRadioButton("Feminino");
        
        ButtonGroup grupoGenero = new ButtonGroup();
        grupoGenero.add(radioMasculino);
        grupoGenero.add(radioFeminino);
        
        panelGenero.add(radioMasculino);
        panelGenero.add(radioFeminino);
        panelPrincipal.add(panelGenero);

        JPanel panelIdiomas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelIdiomas.add(new JLabel("Idiomas:"));
        
        checkEspanhol = new JCheckBox("Espanhol", true); 
        checkIngles = new JCheckBox("Inglês");
        checkItaliano = new JCheckBox("Italiano");
        
        panelIdiomas.add(checkEspanhol);
        panelIdiomas.add(checkIngles);
        panelIdiomas.add(checkItaliano);
        panelPrincipal.add(panelIdiomas);

        JPanel panelNivel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNivel.add(new JLabel("Nível:"));
        
        String[] niveis = {"Fundamental", "Médio", "Universidade"};
        comboNivel = new JComboBox<>(niveis);
        comboNivel.setSelectedIndex(0); 
        panelNivel.add(comboNivel);
        panelPrincipal.add(panelNivel);

        JPanel panelComentarios = new JPanel(new BorderLayout());
        panelComentarios.add(new JLabel("Comentários:"), BorderLayout.NORTH);
        
        areaComentarios = new JTextArea(3, 30);
        areaComentarios.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(areaComentarios);
        panelComentarios.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelComentarios);

        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        
        botaoEnviar = new JButton("Enviar");
        botaoEnviar.addActionListener(e -> enviarDados());
        
        botaoSair = new JButton("Sair");
        botaoSair.addActionListener(e -> System.exit(0));
        
        panelBotoes.add(botaoEnviar);
        panelBotoes.add(botaoSair);
        panelPrincipal.add(panelBotoes);

        add(panelPrincipal);
    }

    private void enviarDados() {
        String nome = campoNome.getText();
        String senha = new String(campoSenha.getPassword());
        
        String genero = radioMasculino.isSelected() ? "Masculino" : "Feminino";
        
        StringBuilder idiomas = new StringBuilder();
        if (checkEspanhol.isSelected()) idiomas.append("Espanhol ");
        if (checkIngles.isSelected()) idiomas.append("Inglês ");
        if (checkItaliano.isSelected()) idiomas.append("Italiano");
        
        String nivel = (String) comboNivel.getSelectedItem();
        String comentarios = areaComentarios.getText();

        String mensagem = "Dados enviados:\n" +
                         "Nome: " + nome + "\n" +
                         "Senha: " + senha + "\n" +
                         "Gênero: " + genero + "\n" +
                         "Idiomas: " + idiomas.toString() + "\n" +
                         "Nível: " + nivel + "\n" +
                         "Comentários: " + comentarios;
        
        JOptionPane.showMessageDialog(this, mensagem, "Dados do Formulário", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame formulario = new MainFrame();
            formulario.setVisible(true);
        });
    }
}