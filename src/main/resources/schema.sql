create table if not exists parameter(
	id UUID primary key,
	data jsonb
);

create table if not exists sop_data(
	id UUID primary key,
	name varchar,
	parameter_id UUID,
	type varchar,
	constraint sop_data_parameter foreign key(parameter_id) references parameter(id)
);

create table if not exists sop(
	id UUID primary key,
	sop_id UUID,
	parent_id UUID,
	sop_order int,
	constraint sop_sop_data foreign key(sop_id) references sop_data(id),
	constraint sop_sop_data_parent foreign key(parent_id) references sop_data(id)
);

create table if not exists condition(
	id UUID primary key,
	process_type varchar,
	role_id varchar,
	task_name varchar
);

create table if not exists sop_condition(
	sop_id UUID,
	condition_id UUID,
	constraint sop_condition_sop foreign key(sop_id) references sop(id),
	constraint sop_condition_condition foreign key(condition_id) references condition(id)
);