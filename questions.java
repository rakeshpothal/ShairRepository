@GetMapping(value = "/getnode/{wfCode}")
	public void getNodeConfig(@PathVariable("wfCode") String wfCode) {
		workFlowService.findByWfCode(wfCode);
	}
	
	
@Override
	public void findByWfCode(String wfCode) {
		try {
			List<NodeDetailsModel> nodeDetailsModelList = workFlowNodeRepository.findByWfCode(wfCode);
			getStartNodeConif(nodeDetailsModelList);

		} catch (Exception e) {
			String message = e.getMessage();
			LOGGER.error("transaction error message:{}", message);
		}

	}
	
	
private void getStartNodeConif(List<NodeDetailsModel> nodeDetailsModels) {
		List<NodeConfig> nodeConfig = nodeConfigBuilder.getNodeConfig(nodeDetailsModels);
		//this  is the data after calling nodeconfigbuilder.getnodeconfig()
NodeConfig [nodeProperties={name=success, id=Activity_14fg3ch}, nodeId=success_1, nodeType=success, incomingNode=null, outgoingNode=null, associatedBoundaryNode=null, sourceNodeConfig=null, isStartnode=false, isEndNode=false]
NodeConfig [nodeProperties={name=email, id=Activity_0j2gefd}, nodeId=email_1, nodeType=email, incomingNode=null, outgoingNode=null, associatedBoundaryNode=null, sourceNodeConfig=null, isStartnode=false, isEndNode=false]
NodeConfig [nodeProperties={name=check, id=Gateway_0nlyn6j}, nodeId=check_1, nodeType=check, incomingNode=null, outgoingNode=null, associatedBoundaryNode=null, sourceNodeConfig=null, isStartnode=false, isEndNode=false]
NodeConfig [nodeProperties={name=failure, id=Activity_0jh0erb}, nodeId=failure_1, nodeType=failure, incomingNode=null, outgoingNode=null, associatedBoundaryNode=null, sourceNodeConfig=null, isStartnode=false, isEndNode=false]
NodeConfig [nodeProperties={name=sms, id=Activity_0ixkxbg}, nodeId=sms_1, nodeType=sms, incomingNode=null, outgoingNode=null, associatedBoundaryNode=null, sourceNodeConfig=null, isStartnode=false, isEndNode=false]
NodeConfig [nodeProperties={name=start, id=StartEvent_1fq70vn}, nodeId=start_1, nodeType=start, incomingNode=null, outgoingNode=null, associatedBoundaryNode=null, sourceNodeConfig=null, isStartnode=false, isEndNode=false]
NodeConfig [nodeProperties={name=end, id=Event_1g6cvxt}, nodeId=end_1, nodeType=end, incomingNode=null, outgoingNode=null, associatedBoundaryNode=null, sourceNodeConfig=null, isStartnode=false, isEndNode=false]
		
		
		

		List<NodeConfig> startNodeConigs = nodeConfig.stream()
				.filter(nodeConfigData -> nodeConfigData.getNodeType().toLowerCase().equals("start"))
				.collect(Collectors.toList());

	//getting filtered data from list as node is first
	NodeConfig [nodeProperties={name=start, id=StartEvent_1fq70vn}, nodeId=start_1, nodeType=start, incomingNode=null, outgoingNode=null, associatedBoundaryNode=null, sourceNodeConfig=null, isStartnode=false, isEndNode=false]
		

	}
