const storeMessage = (_content) => {
    console.log(_content);
    const req = new XMLHttpRequest();
//    req.addEventListener('load', loadMessages);
    req.open("POST", "./api/messages");
    req.setRequestHeader('Content-Type', 'application/json');
    const newMessage = {
    	content: _content
    };
    req.send(JSON.stringify(newMessage));
};

