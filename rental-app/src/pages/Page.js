import React from 'react';
import axios from 'axios';
import DashTable from '../dashComponents/DashTable';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import { Divider } from '@material-ui/core';


export default class Page extends React.Component{
    constructor(){
        super()
        this.state = {
            data:[],
            props:[],
            object:{},
            deleteId:null,
        };
    }
    componentWillMount(){
        axios.get('http://www.kompikownia.pl:8085/'+this.props.path)
        .then(res => {
            const gotData = res.data;
            for (var prop in res.data[0]) {
                if (res.data[0].hasOwnProperty(prop)) {
                    this.state.props.push(prop);
                }
            }
            
            this.setState({
                data:gotData,
            })
            for (const key of this.state.props) {
                this.state.object[key] = "";
           }

            
        });
    }
    send(){
        console.log(this.state.object);
        axios.put('http://www.kompikownia.pl:8085/'+this.props.path,this.state.object).then((response) => console.log(response));
    }
    delete(){
        axios.delete('http://www.kompikownia.pl:8085/'+this.props.path+this.state.deleteId).then((response) => console.log(response));
    }
    storeDeleteId(e){
        this.setState({deleteId:e.target.value})
        console.log(this.state.deleteId);
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
                
                <Divider/>
                
                <TextField style={{width:8.2+'%'}} label="Delete ID" onChange={(e) => this.storeDeleteId(e)}/>
                <Button variant="contained" color="secondary" onClick={this.delete.bind(this)}>Usuń</Button> 

                <DashTable props={this.state.props} data={this.state.data}/>
                
                
            </div>
            
        );
    }
}