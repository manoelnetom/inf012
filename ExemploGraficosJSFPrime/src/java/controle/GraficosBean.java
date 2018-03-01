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
        aluno = new Aluno("", 0);
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
        notas.set("Manoel", 8);
        barModel.addSeries(notas);
        //notas.getData().clear();
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Nome");

        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Nota");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }

    public void updateBarModel() {

        ChartSeries series = barModel.getSeries().get(0);
        if (lista.size() == 0) {
            series.getData().clear();
        }
        lista.add(new Aluno(aluno.getNome(), aluno.getNota()));
        for (int i = 0; i < lista.size(); i++) {
            Aluno temp = (Aluno) lista.get(i);
            series.set(temp.getNome(), temp.getNota());
            System.out.println(temp.getNome());
        }
    }

    public void addNota() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Nota Atualizada com sucesso Com Sucesso", ""));

    }

}
