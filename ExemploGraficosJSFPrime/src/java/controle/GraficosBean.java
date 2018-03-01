/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

    private BarChartModel barModel;
    private Aluno aluno;
    private ArrayList lista;
    public GraficosBean() {
        lista = new ArrayList();
        aluno = new Aluno();
         initBarModel();
    }

    public Aluno getAluno() {
        return aluno;
    }
    
 
    public BarChartModel getBarModel() {
        return barModel;
    }
    
    private void initBarModel() {
        barModel = new BarChartModel();
        barModel.setTitle("Grafico de Notas da Prova");
        barModel.setLegendPosition("ne");
        ChartSeries notas = new ChartSeries();
        notas.setLabel("Prova 1");
        barModel.addSeries(notas);
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Nome");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Nota");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
    

    
    public void addNota(){
        
       //lista.add(aluno);
       
        //List<ChartSeries> series;
       // series = barModel.getSeries();
        
        //for (int i = 0; i < lista.size(); i++) {
          // Aluno temp = (Aluno) lista.get(i);    
         //  series.get(0).set(temp.getNome(), temp.getNota());
        //}
        
        FacesContext context = FacesContext.getCurrentInstance();
        //this.initBarModel();
        context.addMessage(null, new FacesMessage("Nota Add Com Sucesso", ""));
    
    }
    
}
