package com.kh.project.common;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.kh.project.view.foodPanel1;
import com.kh.project.view.foodPanel2;
import com.kh.project.view.foodPanel3;

public class foodResult implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String menu = "";

		int num1 = foodPanel1.getSpinner1();
		int num2 = foodPanel1.getSpinner2();
		int num3 = foodPanel1.getSpinner3();
		int num4 = foodPanel2.getSpinner1();
		int num5 = foodPanel2.getSpinner2();
		int num6 = foodPanel2.getSpinner3();
		int num7 = foodPanel3.getSpinner1();
		int num8 = foodPanel3.getSpinner2();
		int num9 = foodPanel3.getSpinner3();
		
		if(num1 > 0)
			menu += "�⺻ ����" + num1 + "�� ";
		if(num2 > 0)
			menu += "ļ��� ����" + num2 + "�� ";
		if(num3 > 0)
			menu += "ġ�� ����" + num3 + "�� ";
		if(num4 > 0)
			menu += "����" + num4 + "�� ";
		if(num5 > 0)
			menu += "����Ĩ" + num5 + "�� ";
		if(num6 > 0)
			menu += "����ÿ" + num6 + "�� ";
		if(num7 > 0)
			menu += "�ݶ�" + num7 + "�� ";
		if(num8 > 0)
			menu += "���̴�" + num8 + "�� ";
		if(num9 > 0)
			menu += "ȯŸ" + num9 + "�� ";
		
		if(menu == "")
		{
			int result = JOptionPane.showConfirmDialog(null, "�ƹ��͵� �������� �����ðڽ��ϱ�?","Ȯ�� â",JOptionPane.YES_NO_OPTION);
			
			if(result == 0)
			{
				JOptionPane.showMessageDialog(null,  "���� ���� ����", "���� �Ϸ�",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(result == 1)
			{
				JOptionPane.showMessageDialog(null,  "���� ���� ���", "���� ���",JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			menu+=" �����Ͻðڽ��ϱ�?";
			int result = JOptionPane.showConfirmDialog(null, menu,"Ȯ�� â",JOptionPane.YES_NO_OPTION);
			
			if(result == 0)
			{
				JOptionPane.showMessageDialog(null,  "���� ���� �Ϸ�", "���� �Ϸ�",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(result == 1)
			{
				JOptionPane.showMessageDialog(null,  "���� ���� ���", "���� ���",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
