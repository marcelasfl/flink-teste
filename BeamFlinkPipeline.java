import org.apache.beam.runners.flink.FlinkPipelineOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptionsFactory;

public class BeamFlinkPipeline {
    public static void main(String[] args) {
        FlinkPipelineOptions options = PipelineOptionsFactory.as(FlinkPipelineOptions.class);


        // Configura as opções do pipeline
        options.setRunner(FlinkRunner.class);
        options.setFlinkMaster("localhost:8081");
        options.setEnvironmentType("LOOPBACK");

        // Cria o pipeline com as opções configuradas
        Pipeline p = Pipeline.create(options);
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment(
            "localhost", 
            8081,      
            "target/flink-job-1.0-SNAPSHOT.jar" 
        );
        
        

        // Execute o pipeline
        p.run().waitUntilFinish();
    }
}
