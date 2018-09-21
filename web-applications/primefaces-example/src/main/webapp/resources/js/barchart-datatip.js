function tooltipContentEditor(str, seriesIndex, pointIndex, plot) {
    return plot.axes.xaxis.ticks[pointIndex] + ", " + plot.data[seriesIndex][pointIndex];
}