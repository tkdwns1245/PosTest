package manage;

import java.util.ArrayList;

import data.Table;

public class TableManage extends Manage{
	
	ArrayList<Table> tableList = new ArrayList<Table>();
	protected int numOfTable;
	
	public ArrayList<Table> getTableList() {
		return tableList;
	}
	public void setTableList(ArrayList<Table> tableList) {
		this.tableList = tableList;
	}
	public int getNumOfTable() {
		return numOfTable;
	}
	public void setNumOfTable(int numOfTable) {
		this.numOfTable = numOfTable;
	}
	
	
	//index��° ���̺� �� ���
	public void setTable(int index, Table t) {
		tableList.add(index, t);
		//tableList.add(t);
	}
	//index��° ���̺� �� ȣ��
	public Table getTable(int index) {
		return tableList.get(index);
	}

	//���̺� ���
	@Override
	public void Register(Object obj) {
		// TODO Auto-generated method stub
		tableList.add((Table)obj);
		numOfTable++;
	}
	public void Register() {
		// TODO Auto-generated method stub
		tableList.add(new Table(numOfTable));
		numOfTable++;
	}

	//���̺� ����
	@Override
	void Delete(Object obj) {
		// TODO Auto-generated method stub
		tableList.remove((Table)obj);
		numOfTable--;
	}
	void Delete() {
		numOfTable--;
		tableList.remove(numOfTable);
	}
	
	public void dis() {
		for(int i= 0; i < tableList.size(); i++) {
			System.out.println(tableList.get(i).toString(i));
		}
	}
	public void dis(int index) {
		//for(int i= 0; i < tableList.get(index).; i++) {
			System.out.println(tableList.get(index));
		//}
	}
	
}
