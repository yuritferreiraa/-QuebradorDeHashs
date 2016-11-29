/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Logica.ThreadManeger;
import static Utilidades.UtilThread.intervalo;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author dogma
 */
public class NewPage extends Application implements Runnable {
    // Componentes de interface
    private Label labTop;
    private Label labHash;
    private TextField tf;
    private Label labThread;
    private ObservableList<String> numOfThreads;
    private ListView<String> threadNum;
    private Label labDigits;
    private ObservableList<String> numOfDigits;
    private ListView<String> digitsNum;
    private Button startStop;
    private Button[] btnthread;
    private Label labSenha;
    private TextField tfSenha;
    private Label labLoad;
    private TextField[] tfLoad;
    private Label labBig1;
    private Label labBig2;
    private Label labTime;
    private TextField tfTime;
    
    // variaveis
    private int loading;
    private Thread thrd;
    private Thread thrdSenha;
    private ThreadManeger tm;
    private int threads;
    private int digits;
    private String hash[] = new String[1];
    private boolean stop = true;
    private boolean active = false;
    long tempoInicio;
    int tempoFinal;
    int tempoReal;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Hash Decoder");
        myStage.centerOnScreen();
        myStage.setResizable(true);
        
        // cria os painéis 
        BorderPane rootNode = new BorderPane();
        FlowPane leftNode = new FlowPane();
        FlowPane topNode = new FlowPane();
        FlowPane rightNode = new FlowPane();
        FlowPane centerNode = new FlowPane();

        // alinha. O Hgap e Vgap afastam os componentes
        centerNode.setAlignment(Pos.CENTER);
        centerNode.setTranslateY(-200);
        centerNode.setVgap(25);
        centerNode.setHgap(10);
        topNode.setAlignment(Pos.CENTER);
        topNode.setVgap(15);
        rightNode.setAlignment(Pos.CENTER);
        rightNode.setTranslateY(-200);
        rightNode.setHgap(15);
        rightNode.setVgap(15);
        leftNode.setAlignment(Pos.CENTER);
        leftNode.setHgap(15);
        leftNode.setVgap(15);
        
        // posiciona o leftNode no lado esquerdo da tela
        rootNode.setTop(topNode);
        rootNode.setLeft(leftNode);
        rootNode.setRight(rightNode);
        rootNode.setCenter(centerNode);
        
        // cria a scene e a estabelece no mystage
        Scene myScene = new Scene(rootNode, 1280, 720);
        myStage.setScene(myScene);
        
        // cria e personaliza os componentes(nós)
        Separator lineTop = new Separator();
        Separator line1 = new Separator();
        Separator line2 = new Separator();
        lineTop.setPrefWidth(1280);
        line1.setPrefWidth(125);
        line2.setPrefWidth(125);
        labTop = new Label("Hash Decoder SENAC/FATEC ADS 2016/2");
        labHash = new Label("Hash(MD5): ");
        tf = new TextField("F657A47BBDB90F97364138EB933D13CB");
        numOfThreads = FXCollections.observableArrayList("1", "2", "3",
                "4", "5", "6","7", "8", "9", "10", "11", "12", "13", "14",
                "15", "16", "17", "18");
        numOfDigits = FXCollections.observableArrayList("1", "2", "3", "4", "5");
        labThread = new Label("Threads: ");
        threadNum = new ListView(numOfThreads);
        labDigits = new Label("Digitos: ");
        digitsNum = new ListView(numOfDigits);
        startStop = new Button("Start");
        labLoad = new Label("Loading");
        labLoad.setVisible(false);
        tfLoad = new TextField[10];
        for (int i = 0; i < 10; i++) {
            tfLoad[i] = new TextField("");
            tfLoad[i].setPrefWidth(5);
            tfLoad[i].setVisible(false);
        }
        startStop.setPrefWidth(100);
        threadNum.setPrefSize(80, 30);
        digitsNum.setPrefSize(60, 30);
        labSenha = new Label("Senha");
        tfSenha = new TextField();
        tfSenha.setText("");
        labSenha.setTranslateY(20);
        tfSenha.setTranslateY(20);
        labSenha.setVisible(false);
        tfSenha.setVisible(false);
        labBig1 = new Label("HASH");
        labBig1.setTranslateY(345);
        labBig1.setTranslateX(-50);
        labBig1.setId("BigLabe");
        labBig2 = new Label("DECODER");
        labBig2.setTranslateY(375);
        labBig2.setTranslateX(-220);
        labBig2.setId("BigLabe");
        labTime = new Label("Tempo:");
        labTime.setTranslateX(-110);
        labTime.setTranslateY(500);
        tfTime = new TextField();
        tfTime.setPrefColumnCount(3);
        tfTime.setTranslateX(120);
        tfTime.setTranslateY(417);
        labTime.setVisible(false);
        tfTime.setVisible(false);
        
        
        // comfigura a acão do botão startStop
        startStop.setOnAction((ae) -> {
            if (stop) {
                tempoInicio = System.currentTimeMillis();
                hash[0] = tf.getText();
                threads = (threadNum.getSelectionModel().getSelectedIndex())+1;
                digits = (digitsNum.getSelectionModel().getSelectedIndex())+1;
                tm = null;
                thrdSenha = null;
                thrdSenha = new Thread(this);
                tm = new ThreadManeger(threads, digits, hash);
                thrd = new Thread(tm);
                thrd.start();
                for (int i = 0; i < threads; i++) { 
                    btnthread[i].setStyle("-fx-background-color: skyblue;");
                    btnthread[i].setText(btnthread[i].getText().replaceAll("\n desativada", "\n acionada"));
                }
                startStop.setText("Stop");
                stop = false;
                if (!active) {
                    active = true;
                    thrdSenha.start();
                }
            } else if(active) {
                tm.pararThreadsPorFind();
                for (int i = 0; i < threads; i++) { 
                    btnthread[i].setStyle("-fx-background-color: beige;");
                    btnthread[i].setText(btnthread[i].getText().replaceAll("\n acionada", "\n desativada"));
                }
                startStop.setText("Start");
                active=false;
                tfSenha.setText(tm.getPassFind());
            } else {
                    tfSenha.setText("");
                    startStop.setText("Start");
                    stop=true;
                    labTime.setVisible(false);
                    tfTime.setVisible(false);
                    labSenha.setVisible(false);
                    tfSenha.setVisible(false);
                    for (int i = 0; i < 10; i++) {
                    tfLoad[i].setVisible(false);
                    labLoad.setVisible(false);
                }
            }
        });
        
        //adiciona os componentes
        rightNode.getChildren().addAll(labSenha, tfSenha, labBig2, labTime, tfTime);
        topNode.getChildren().addAll(labTop, lineTop);
        leftNode.getChildren().addAll(labHash, tf, labThread, threadNum,
        labDigits, digitsNum, line1, startStop, line2);
        centerNode.getChildren().add(labLoad);
        centerNode.getChildren().addAll(tfLoad);
        centerNode.getChildren().add(labBig1);
        
        // cria, seta e adiciona os botões threads
        btnthread = new Button[18];
        for (int i = 0; i < 18; i++) {
            btnthread[i] = new Button((i+1)+"º Thread\n desativada");
            leftNode.getChildren().add(btnthread[i]);
        }
        
        // vincula arquivo css
        myScene.getStylesheets().add("view/back.css");
        
        //Desativa as thread ao fechar pela janela
        myStage.setOnCloseRequest((ae) -> {
            if (tm != null) {
                tm.pararThreadsPorFind();
            }
        active = false;
        Platform.exit();
        });
        myStage.show();
    }

       public void setTfSenha(String passFind) {
        tfSenha.setText(passFind);
    }

    @Override
    public void run() {
        // atualiza o campo senha
        labSenha.setVisible(true);
        tfSenha.setVisible(true);
        while(active) {
            intervalo(3000);
            tfLoad[loading].setVisible(true);
            loading++;
            labLoad.setVisible(true);
            if(loading==10) {
                loading=0;
                for (int i = 0; i < 10; i++) {
                    tfLoad[i].setVisible(false);
                }
            }
            if (tm.getPassFind().equals("Procurando")) tfSenha.setText("Senha!!!");
            if (tm != null) {
                intervalo(3000);
                tfSenha.setText(""+tm.getPassFind());
                if (!(tm.getPassFind().equals("Procurando"))) active= false;
                tfLoad[loading].setVisible(true);
                loading++;
                if(loading==10) {
                    loading=0;
                    for (int i = 0; i < 10; i++) {
                    tfLoad[i].setVisible(false);
                    }
                }
            }
        }
        loading=0;
        CalculoDeTempo();
    }
    
    public void CalculoDeTempo() {
        labTime.setVisible(true);
        tfTime.setVisible(true);
        tempoFinal= (int) ((System.currentTimeMillis()-tempoInicio)/1000);
        if (tempoFinal<10) {
            tfTime.setText("00"+":0"+tempoFinal);
        } else if (tempoFinal<60) {
            tfTime.setText("00"+":"+tempoFinal);
        } else if ((tempoFinal=tempoFinal/60)%1==0) {
            tfTime.setText(tempoFinal+":00");
        } else {
            tempoReal = ((tempoFinal%1)*1000)/60;
            tempoReal = (tempoFinal-tempoFinal%1)+tempoReal;
            tfTime.setText(tempoFinal+":"+tempoReal);
        }
        
    }
}
