Simple test to see if otel javaagent send default jul logs to signoz server.

Run:
 java -javaagent:opentelemetry-javaagent.jar "-Dotel.service.name=otel-se" "-Dotel.logs.exporter=otlp" "-Dotel.exporter.otlp.endpoint=[endpoint]" -jar AgentSeTest-1.0.jar 1000
