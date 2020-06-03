package controller;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import Entity.Order;
import Entity.orderTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class OrderTableController implements Initializable{

	@FXML
	private TableView <orderTable> table;
	@FXML
	private TableColumn <orderTable,String> col_name;
	@FXML
	private TableColumn <orderTable,String> col_type ;
	@FXML
	private TableColumn <orderTable,Integer> col_amount;
	@FXML
	private TableColumn <orderTable,Double> col_cost;
	@FXML
	private TableColumn <orderTable,String> col_date;
	@FXML
	private TableColumn <orderTable,String> col_due;
	
	ObservableList<orderTable> orederList = FXCollections.observableArrayList();	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Order o = new Order();
		ResultSet rs = o.getOrders(); 
	
		col_name.setCellValueFactory(new PropertyValueFactory<>("Order id"));
		col_type.setCellValueFactory(new PropertyValueFactory<>("Order type"));
		col_amount.setCellValueFactory(new PropertyValueFactory<>("Amount"));
		col_cost.setCellValueFactory(new PropertyValueFactory<>("Cost"));
		col_date.setCellValueFactory(new PropertyValueFactory<>("Order date"));
		col_due.setCellValueFactory(new PropertyValueFactory<>("Due"));

	
	}

	

}
