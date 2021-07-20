package calculabytes;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class CalculoPara extends RecursiveTask<Long>{
    static long size = 0;
    File file;
    
    public CalculoPara(File file){
        this.file = file;
    }

    @Override
    protected Long compute() {
        if(file.isFile()){
            return file.length();
        }
        return CalculoPara.invokeAll(criarSubtarefas(file)).stream().mapToLong(CalculoPara::join).sum();
    }
    
    private Collection<CalculoPara> criarSubtarefas(File file){
        List<CalculoPara> tarefasDivididas = new ArrayList<>();
        File[] cont = file.listFiles();
        for (File arq : cont){
            tarefasDivididas.add(new CalculoPara(arq));
        }
        return tarefasDivididas;
    }
}
