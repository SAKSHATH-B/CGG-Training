import React, { useEffect, useState } from "react";
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from "reactstrap";
import AddQuiz from "../AddQuiz";

const Mod = ({ modal2, backdrop, setModal, categoriesPacket, section }) => {
  const setModalFunc = setModal;
  const toggle = () => setModalFunc(!modal2);
  return (
    <div>
      <Modal
        isOpen={modal2}
        toggle={toggle}
        backdrop={backdrop}
        section={section}
      >
        <ModalHeader toggle={toggle}> </ModalHeader>
        <ModalBody>
          <AddQuiz toggle={toggle} categoryPacket={categoriesPacket} />
        </ModalBody>
        <ModalFooter>
          {/* <Button color="primary" onClick={toggle}>
            save
          </Button>
          <Button color="secondary" onClick={toggle}>
            Cancel
          </Button> */}
        </ModalFooter>
      </Modal>
    </div>
  );
};

export default Mod;
