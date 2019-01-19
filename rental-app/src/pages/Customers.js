import React from 'react';
import axios from 'axios';
import DashTable from '../dashComponents/DashTable';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Input from '@material-ui/core/Input';


export default class Customers extends React.Component{
    constructor(){
        super()
        this.state = {
            users:[],
            props:[],
            object:{}
        };
    }
    componentWillMount(){
        axios.get('http://www.kompikownia.pl:8085/customer/' )
        .then(res => {
            const usersData = res.data;
            for (var prop in res.data[0]) {
                if (res.data[0].hasOwnProperty(prop)) {
                    this.state.props.push(prop);
                }
            }
            
            this.setState({
                users:usersData,
            })
            for (const key of this.state.props) {
                this.state.object[key] = "";
           }
            console.log(this.state.object);
            
        });
    }
    send(){
        console.log(this.state.object);
        axios.put('http://www.kompikownia.pl:8085/customer/',this.state.object).then((response) => console.log(response));
    }

    collectData(e,prop){
        let object = Object.assign({}, this.state.object);
        object[prop] = e.target.value;
        this.setState({object})
    }
    render(){
        return(
            <div>

                {this.state.props.map((prop) =>( 
                    <TextField key={prop} style={{width:8.2+'%'}} label={prop} onChange={(e) => this.collectData(e,prop)}/> 
                ))}
                <Button variant="contained" color="primary" onClick={this.send.bind(this)}>Dodaj</Button>

                <DashTable props={this.state.props} data={this.state.users}/>
                
                
            </div>
            
        );
    }
}