
graph LR
A[Input Preprocessing] --> B{Page Type}
B --> C1[HP: Sub-concept distribution]
B --> C2[CLP: Sub-concept → store distribution]
C1 --> D1[ROLS call per sub-concept]
C2 --> D2[ROLS call per store]
D1 --> E1[Widgetization (concept spacing)]
D2 --> E2[Widgetization (store spacing)]
E1 --> F[Final Ranked List]
E2 --> F
