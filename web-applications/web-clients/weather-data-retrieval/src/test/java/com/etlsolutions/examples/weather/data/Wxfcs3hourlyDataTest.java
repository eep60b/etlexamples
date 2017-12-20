package com.etlsolutions.examples.weather.data;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Test of class Wxfcs3hourlyData.
 *
 * @author zc
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Wxfcs3hourlyData.class})
public final class Wxfcs3hourlyDataTest {

    private final FeelTemperature feelTemperature = PowerMockito.mock(FeelTemperature.class);
    private final PrecipitationProbability precipitationProbability = PowerMockito.mock(PrecipitationProbability.class);
    private final RealTemperature realTemprature = PowerMockito.mock(RealTemperature.class);
    private final PredictedVisibility predictedVisibility = PredictedVisibility.VERY_GOOD;
    private final RelativeHumidity relativeHumidity = PowerMockito.mock(RelativeHumidity.class);
    private final UvIndex uvIndex = PowerMockito.mock(UvIndex.class);
    private final WeatherType weatherType = WeatherType.HEAVY_RAIN;
    private final WindDirection windDirection = WindDirection.ESE;
    private final WindGust windGust = PowerMockito.mock(WindGust.class);
    private final WindSpeed windSpeed = PowerMockito.mock(WindSpeed.class);

    private final Wxfcs3hourlyData instance = new Wxfcs3hourlyData(null, feelTemperature, precipitationProbability, realTemprature, predictedVisibility, relativeHumidity, uvIndex, weatherType, windDirection, windGust, windSpeed);

    /**
     * Test of getValuables method.
     */
    @Test
    public void testGetValuables() {

        assertArrayEquals(new Valuable[]{feelTemperature, precipitationProbability, realTemprature, predictedVisibility, relativeHumidity, uvIndex, weatherType, windDirection, windGust, windSpeed}, instance.getValuables());
    }
}
