function ext() {
    // this = chart widget instance        
    // this.cfg = options            
    this.cfg.grid = {
        background: 'green',
        gridLineColor: '#303030',
        drawBorder: false
    };

    this.cfg.height = 1000;

    this.cfg.highlighter = {
        tooltipContentEditor: function (str, seriesIndex, pointIndex, plot) {
            return plot.axes.xaxis.ticks[pointIndex] + ", " + plot.data[seriesIndex][pointIndex];
        },
        show: true,
     
        useAxesFormatters: true,
        tooltipAxes: 'both'
    };
}