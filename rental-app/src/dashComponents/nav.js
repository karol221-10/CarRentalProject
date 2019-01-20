import React from 'react';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import ListSubheader from '@material-ui/core/ListSubheader';
import DashboardIcon from '@material-ui/icons/Dashboard';
import ShoppingCartIcon from '@material-ui/icons/ShoppingCart';
import PeopleIcon from '@material-ui/icons/People';
import AssignmentIcon from '@material-ui/icons/Assignment';
import DirectionsCar from '@material-ui/icons/DirectionsCar';
import Build from '@material-ui/icons/Build';
import Home from '@material-ui/icons/Home';
import BusinessCenter from '@material-ui/icons/BusinessCenter';
import AttachMoney from '@material-ui/icons/AttachMoney';
import Description from '@material-ui/icons/Description';
import {Link} from 'react-router-dom';

export const mainListItems = (
  <div>
    <ListItem button component={Link} to="/">
      <ListItemIcon>
        <DashboardIcon />
      </ListItemIcon>
      <ListItemText primary="Dashboard" />
    </ListItem>
    <ListItem button component={Link} to="/car">
      <ListItemIcon>
      <DirectionsCar/>
      </ListItemIcon>
      <ListItemText primary="Auta" />
    </ListItem>
    <ListItem button component={Link} to="/carreturn">
      <ListItemIcon>
        <ShoppingCartIcon />
      </ListItemIcon>
      <ListItemText primary="Zwroty aut" />
    </ListItem>
    <ListItem button component={Link} to="/customer">
      <ListItemIcon>
        <PeopleIcon />
      </ListItemIcon>
      <ListItemText primary="Klienci" />
    </ListItem>
    <ListItem button component={Link} to="/facility">
      <ListItemIcon>
        <Home/>
      </ListItemIcon>
      <ListItemText primary="Placówki" />
    </ListItem>
    <ListItem button component={Link} to="/insurance">
      <ListItemIcon>
        <BusinessCenter/>
      </ListItemIcon>
      <ListItemText primary="Ubezpieczenia" />
    </ListItem>
    <ListItem button component={Link} to="/invoice">
      <ListItemIcon>
        <Description/>
      </ListItemIcon>
      <ListItemText primary="Faktury" />
    </ListItem>
    <ListItem button component={Link} to="/pricelist">
      <ListItemIcon>
        <AttachMoney/>
      </ListItemIcon>
      <ListItemText primary="Cennik" />
    </ListItem>
    <ListItem button component={Link} to="/rental">
      <ListItemIcon>
        <DirectionsCar/>
      </ListItemIcon>
      <ListItemText primary="Wypożyczenia" />
    </ListItem>
    <ListItem button component={Link} to="/servicing">
      <ListItemIcon>
        <Build/>
      </ListItemIcon>
      <ListItemText primary="Serwis" />
    </ListItem>
    <ListItem button component={Link} to="/worker">
      <ListItemIcon>
        <PeopleIcon />
      </ListItemIcon>
      <ListItemText primary="Pracownicy" />
    </ListItem>
  </div>
);

export const secondaryListItems = (
  <div>
    <ListSubheader inset>raporty</ListSubheader>
    <ListItem button>
      <ListItemIcon>
        <AssignmentIcon />
      </ListItemIcon>
      <ListItemText primary="Obecny miesiac" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <AssignmentIcon />
      </ListItemIcon>
      <ListItemText primary="ostatni kwartał" />
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <AssignmentIcon />
      </ListItemIcon>
      <ListItemText primary="roczny raport" />
    </ListItem>
  </div>
);
