import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI extends JFrame implements ActionListener
{
	Information info = new Information();
	private JTextField txtPrsNr;
	private JButton okButton;
	private JButton removeBtn;
	private JButton createBtn;
	private JList accountList;
	private JTextArea infoArea;
	private DefaultListModel listModel;
	
	public GUI(String title)
	{
		setTitle(title);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel topPnl = new JPanel();
		txtPrsNr = new JTextField(10);
		okButton = new JButton("Ok");
		removeBtn = new JButton("Remove");
		removeBtn.addActionListener(this);
		okButton.addActionListener(this);
		topPnl.add(new JLabel("Personnummer:"));
		topPnl.add(txtPrsNr);
		topPnl.add(okButton);
		topPnl.add(removeBtn);
		topPnl.setVisible(true);
		
		JPanel midPnl = new JPanel(new BorderLayout());
		infoArea = new JTextArea();
		infoArea.setPreferredSize(new Dimension(150, 100));
		infoArea.setEditable(false);
		JScrollPane spInfo = new JScrollPane(infoArea);
		listModel = new DefaultListModel<String>();
		accountList = new JList<String>(listModel);
		JScrollPane spAccount = new JScrollPane(accountList);
		midPnl.add(spInfo, BorderLayout.LINE_START);
		midPnl.add(spAccount, BorderLayout.CENTER);
		
		JPanel botPnl = new JPanel();
		createBtn = new JButton("Create new account");
		createBtn.addActionListener(this);
		botPnl.add(createBtn);
		
		topPnl.setVisible(true);
		midPnl.setVisible(true);
		botPnl.setVisible(true);
		add(topPnl, BorderLayout.PAGE_START);
		add(midPnl, BorderLayout.CENTER);
		add(botPnl, BorderLayout.PAGE_END);
		pack();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == okButton)
		{
			String name = txtPrsNr.getText();
			info.addCustomer(name);
			listModel.addElement(name);
			infoArea.append(name);
		}
		else if(event.getSource() == removeBtn)
		{
			int idx = accountList.getSelectedIndex();
			listModel.remove(idx);
		}
		else if(event.getSource() == createBtn)
		{
			createAccount frame = new createAccount();
			frame.setVisible(true);
		}
	}
	
	public static void main(String[] agrs)
	{
		SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						GUI frame = new GUI("GUI - test");
						frame.setVisible(true);
					}
				});
	}
}
//----------------------------------NEW CLASS--------------------------------------------------------//

class createAccount extends JFrame implements ActionListener
{
	private JButton addBtn;
	JTextField txtAccount;
	JTextField txtBalance;
	JTextField txtRate;
	private ArrayList<SavingsAccount> accounts;
	public createAccount()
	{
		accounts = new ArrayList<>();
		setLocationRelativeTo(null);
		setSize(400, 400);
		
		JPanel pnl = new JPanel();
		txtAccount = new JTextField(10);
		txtBalance = new JTextField(10);
		txtRate = new JTextField(10);
		addBtn = new JButton("Create account");
		addBtn.addActionListener(this);
		pnl.add(new JLabel("Account name:"));
		pnl.add(txtAccount);
		pnl.add(new JLabel("Balance:"));
		pnl.add(txtBalance);
		pnl.add(new JLabel("Rate:"));
		pnl.add(txtRate);
		pnl.add(addBtn);
		
		add(pnl);
		pack();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		setVisible(false);
	}
	
	public void createAccount()
	{
		String accountName = txtAccount.getText();
		double accountBalance = Double.parseDouble(txtBalance.getText());
		double rate = Double.parseDouble(txtRate.getText());
		SavingsAccount account = new SavingsAccount(accountBalance, rate, accountName);
		accounts.add(account);
	}
	
	public void showAccounts()
	{
		for(int i = 0; i < accounts.size(); i++)
		{
			SavingsAccount account = accounts.get(i);
			System.out.println(account.getAccountName() + " " + account.getAccountNr() + " " + account.getBalance() + " " + account.getRate());
		}
	}
}
