import "./App.css";
import { BasicTable } from "./Components/BasicTable";
import { ColumnHiding } from "./Components/ColumnHiding";
import { ColumnOrder } from "./Components/ColumnOrder";
import { FilteringTable } from "./Components/FilteringTable";
import { PaginationTable } from "./Components/PaginationTable";
import { RowSelection } from "./Components/RowSelection";
import { SortingTable } from "./Components/SortingTable";
import { StickyTable } from "./Components/StickyTable";

function App() {
  return (
    <>
      {/* <BasicTable /> */}
      {/* <SortingTable /> */}
      {/* <FilteringTable /> */}
      {/* <PaginationTable /> */}
      {/* <RowSelection /> */}
      {/* <ColumnOrder /> */}
      {/* <ColumnHiding /> */}
      <StickyTable />
    </>
  );
}

export default App;
