import React from 'react';
import PropTypes from 'prop-types';

import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';




export default class DashTable extends React.Component {
  constructor(){
    super()
  }
  render(){
    return (
      <Paper >
        <Table >
          <TableHead>
            <TableRow>
              {this.props.props.map((column) => (
                <TableCell  key={column}>{column}</TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {this.props.data.map((n,i) => (
              <TableRow key={i}>
                {this.props.props.map((column,j) =>(
                    <TableCell key={i.toString()+j}>{n[column]}</TableCell>
                ))}
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </Paper>
    );
  }
  
}

