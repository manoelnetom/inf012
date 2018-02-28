/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import negocio.Aluno;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author ManoelNeto
 */
@Named(value = "graficosBean")
@SessionScoped
public class GraficosBean implements Serializable {

    /**
     * Creates a new instance of GraficosBean
     */
    private BarChartModel barModel;
    private Aluno aluno;
    public GraficosBean() {
    }

    public Aluno getAluno() {
        return aluno;
    }
    
    @PostConstruct
    public void init() {
        createBarModel();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
    
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries notas = new ChartSeries();
        notas.setLabel("Prova 1");
        notas.set("Manoel", 8);
        notas.set("Caio", 9);
        notas.set("Joao", 7);
        notas.set("Milena", 8);
        notas.set("Ricardo", 7);
        model.addSeries(notas);
       
         
        return model;
    }
    
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Grafico de Notas da Prova");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Nome");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Nota");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
    
    public void addNota(){
        
    }
    
}
