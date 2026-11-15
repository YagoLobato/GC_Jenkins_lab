import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ConversorTest {
    @Test void fParaC_ebulicao()     { assertEquals(100.0, Conversor.fahrenheitParaCelsius(212), 0.001); }
    @Test void fParaC_congelamento() { assertEquals(0.0, Conversor.fahrenheitParaCelsius(32), 0.001); }
    @Test void cParaF_ebulicao()     { assertEquals(212.0, Conversor.celsiusParaFahrenheit(100), 0.001); }
    @Test void cParaF_congelamento() { assertEquals(32.0, Conversor.celsiusParaFahrenheit(0), 0.001); }
}