import React, { useState, useEffect } from 'react';
import { DataGrid } from '@mui/x-data-grid';
import { getCustomers } from '../api/DvdRentalApi'
import { Customer } from '../types/Customer';

export default function FlexLayoutGrid() {
    const [customers, setCustomers] = useState<Customer[]>([]);
    useEffect(() => {
        updateGrid();
    }, [])

    function updateGrid() {

        getCustomers().then(items => {
            if (items instanceof Error) {
                console.log(items);
            }
            else {
                setCustomers(items)
            }
        })
        return;
    };

    const columns = [
        { field: 'customerId', headerName: 'ID', flex: 0.1 },
        { field: 'lastName', headerName: 'Last Name', flex: 0.20 },
        { field: 'firstName', headerName: 'First Name', flex: 0.20 },
        { field: 'email', headerName: 'Email', flex: 0.50 },
    
    
    ];


    return (
        <div style={{ height: 400, width: '100%' }}>
            <div style={{ display: 'flex', height: '100%' }}>
                <div style={{ flexGrow: 1 }}>
                <DataGrid
                rows={customers}
                columns={columns}
                pageSize={9}
                rowsPerPageOptions={[9]}
                checkboxSelection
                onRowClick={(params, event) => {
                    event.defaultMuiPrevented = true;
                    
                }}
                onSelectionModelChange={(newSelection) => {
                    
                }}
                columnVisibilityModel={{
                    id: false,
                }}
            />
                </div>
            </div>
        </div>
    );
}
