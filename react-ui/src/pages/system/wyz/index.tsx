import React from "react";
import WrapContent from "@/components/WrapContent";
import {Card} from "antd";

export type GlobalTableProps = {};

const TableList: React.FC<GlobalTableProps> = () => {
  return (
    <WrapContent>
      <Card title="Developing 开发中，请给个星星支持支持！" />
    </WrapContent>
  );
};

// export default TableList;
export default TableList;
