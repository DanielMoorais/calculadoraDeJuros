import java.text.DecimalFormat;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class ControllerCalculadora {

    @FXML
    private Button buttonCalcular;

    @FXML
    private Button buttonCalcular1;

    @FXML
    private Slider sliderParcelas;

    @FXML
    private TextField textFieldValor;

    @FXML
    private TextField textFieldJuros;

    @FXML
    private TextField textFieldParcela;

    @FXML
    private TextField textFieldTotal;

    int quantidadeParcelas;
    double taxaJuros;

    public void taxasDeJuros(int parcela){
        switch(parcela){
            case 1:
                taxaJuros = 4.9;
                break;
            case 2:
                taxaJuros = 9.8;
                break;
            case 3:
                taxaJuros = 11.1;
                break;
            case 4:
                taxaJuros = 12.5;
                break;
            case 5:
                taxaJuros = 13.8;
                break;
            case 6:
                taxaJuros = 15.1;
                break;
            case 7:
                taxaJuros = 16.4;
                break;
            case 8:
                taxaJuros = 17.7;
                break;
            case 9:
                taxaJuros = 19.0;
                break;
            case 10:
                taxaJuros = 20.1;
                break;
            case 11:
                taxaJuros = 21.3;
                break;
            case 12:
                taxaJuros = 22.4;
                break;
            default:
            System.out.println("Nao foi escolhido um numero de parcelas. Escolha uma parcela e tente novamente!");
        }
    }

    @FXML
    void eventoDeClique(ActionEvent event) {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("*TAXAS DE JUROS*\n" + "1x: 4,9%\n" + "2x: 9,8%\n"+ "3x: 11,1%\n"+ "4x: 12,5%\n"+ "5x: 13,8%\n"
        + "6x: 15,1%\n" + "7x: 16,4%\n"+ "8x: 17,7%\n"+ "9x: 19,0%\n"+ "10x: 20,1%\n"+ "11x: 21,3%\n"+ "12x: 22,4%");

        try{
            taxasDeJuros(quantidadeParcelas);
            double valorDigitado = Double.parseDouble(textFieldValor.getText());
            double valorFinal = ((valorDigitado * taxaJuros)/100) + valorDigitado;
            double valorParcela = (valorFinal/quantidadeParcelas);
            textFieldJuros.setText(taxaJuros + " %");
            textFieldParcela.setText("R$ " + df.format(valorParcela));
            textFieldTotal.setText("R$ " + valorFinal);
        }
        catch (NumberFormatException e){
            textFieldValor.setText("Digite o valor da compra:");
            textFieldValor.selectAll();
            textFieldValor.requestFocus();
        }
    }

    public void initialize(){
        sliderParcelas.valueProperty().addListener(new ChangeListener<Number>() {
        @Override
        public void changed(ObservableValue<? extends Number> ov, Number valorAntigo, Number valorNovo){
        quantidadeParcelas = Integer.valueOf(valorNovo.intValue());
        }
        });
    }
}