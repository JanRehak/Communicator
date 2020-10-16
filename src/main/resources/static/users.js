document.addEventListener("DOMContentLoaded", () => {
    loadUsers();
    loadRoles();
    document.getElementsByName('addUser')[0].addEventListener('submit', event => {
        	event.preventDefault();
        	storeUser(
        			document.addUser.name.value,
        			document.addUser.lastName.value,
        			document.addUser.streetName.value,
        			document.addUser.password.value,
        			Array.from(document.addUser.roles.selectedOptions).map(o => o.value)
    		);
        	return false;
        });
});



const storeUser = (name, lastName, streetName, password, roleIds) => {
    const req = new XMLHttpRequest();
    req.addEventListener('load', loadUsers);
    req.open("POST", "./api/users");
    req.setRequestHeader('Content-Type', 'application/json');

    const newUser = {
        name: name,
        lastName: lastName,
        streetName: streetName,
        password: password,
        roles: roleIds.map(roleId => ({ id: roleId }))
    };
    req.send(JSON.stringify(newUser));
};



const loadUsers = () => {
    const req = new XMLHttpRequest();
    req.addEventListener('load', () => {
        const tableBody = document.getElementById('users-list');
        tableBody.innerHTML = '';
        const user = JSON.parse(req.responseText);
        user.forEach(user => createRow(tableBody, user, user.roles));
    });
    req.open("GET", "./api/users");
    req.send();
};



const loadRoles = () => {
    const req = new XMLHttpRequest();
    req.addEventListener('load', () => {
        const rolesSelect = document.getElementById('role-selector');
        rolesSelect.innerHTML = '';
        const roles = JSON.parse(req.responseText);
        roles.forEach(role => {
        	const roleOption = document.createElement('option');
        	roleOption.value = role.id;
        	roleOption.innerText = role.name;
        	rolesSelect.append(roleOption);
        });
    });
    req.open("GET", "./api/roles");
    req.send();
};



const createRow = (tableBody, user, roles) => {
    const nameCell = document.createElement('td');
    nameCell.innerText = user.name;

    const lastNameCell = document.createElement('td');
    lastNameCell.innerText = user.lastName;

    const streetNameCell = document.createElement('td');
    streetNameCell.innerText = user.streetName;

    const rolesCell = document.createElement('td');
    roles.forEach(role => { par = document.createElement('p');
    par.innerText = role.name;
    rolesCell.append(par);
    })

    const idCell = document.createElement('td');
    idCell.innerText = user.id;

    const topicRow = document.createElement('tr');
    topicRow.append(nameCell, lastNameCell, streetNameCell, rolesCell, idCell);
    tableBody.append(topicRow);


};


