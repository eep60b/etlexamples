/* 
 * This code prevent the double clicks. It is used in the dialog-with-ok-button.xhtml page.
 * 
 * This code has NOT been tested. It doesn't seem to work at the moment.
 */

function handleDisableButton(data) {
  
    if (data.source.type !== "submit") {
        return;
    }

    switch (data.status) {
        case "begin":
            data.source.disabled = true;
            break;
        case "complete":
            data.source.disabled = false;
            break;
    }    
}

